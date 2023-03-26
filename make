#!/usr/bin/env bash

export DOCKER_BUILDKIT=1
export COMPOSE_DOCKER_CLI_BUILD=1

CI_DOCKER_IMAGE="${CI_DOCKER_IMAGE:-registry.gitlab.com/reconquista-lebed/shop-with-redis}"
CI_DOCKER_TAG="${CI_DOCKER_TAG:-$(git rev-parse --abbrev-ref HEAD)}"

if [[ "$1 $2" == "docker login" ]]; then
    docker login registry.gitlab.com || exit 1
elif [[ "$1 $2 $3" == "docker build dependency" ]]; then
    if [[ "$4" ]]; then
        CI_DOCKER_TAG="$3"
    fi

    docker build --pull --platform amd64 \
        --tag "registry.gitlab.com/reconquista-lebed/shop-with-redis:dependency-${CI_DOCKER_TAG}" \
        --cache-from "registry.gitlab.com/reconquista-lebed/shop-with-redis:dependency-${CI_DOCKER_TAG}" \
        --build-arg DOCKER_DEPENDENCY_IMAGE="${DOCKER_DEPENDENCY_IMAGE:-gradle:7.6.1-jdk11}" \
        --build-arg DOCKER_RUNTIME_IMAGE="${DOCKER_RUNTIME_IMAGE:-openjdk:11-jre-slim}" \
        --build-arg BUILDKIT_INLINE_CACHE=1 \
        --target dependency-image \
        --file "Dockerfile" \
        ./ \
    || exit 1
elif [[ "$1 $2 $3" == "docker push dependency" ]]; then
    docker push "registry.gitlab.com/reconquista-lebed/shop-with-redis:dependency-${CI_DOCKER_TAG}" || exit 1
elif [[ "$1 $2" == "docker build" ]]; then
    if [[ "$3" ]]; then
        CI_DOCKER_TAG="$3"
    fi

    docker pull "registry.gitlab.com/reconquista-lebed/shop-with-redis:dependency-${CI_DOCKER_TAG}" || true

    docker build --pull --platform amd64 \
        --tag "registry.gitlab.com/reconquista-lebed/shop-with-redis:${CI_DOCKER_TAG}" \
        --cache-from "registry.gitlab.com/reconquista-lebed/shop-with-redis:dependency-${CI_DOCKER_TAG}" \
        --build-arg DOCKER_DEPENDENCY_IMAGE="${DOCKER_DEPENDENCY_IMAGE:-gradle:7.6.1-jdk11}" \
        --build-arg DOCKER_RUNTIME_IMAGE="${DOCKER_RUNTIME_IMAGE:-openjdk:11-jre-slim}" \
        --build-arg BUILDKIT_INLINE_CACHE=1 \
        --target runtime-image \
        --file "Dockerfile" \
        ./ \
    || exit 1
elif [[ "$1 $2" == "docker push" ]]; then
    docker push "registry.gitlab.com/reconquista-lebed/shop-with-redis:${CI_DOCKER_TAG}" || exit 1
elif [[ "$1 $2" == "docker run" ]]; then
    docker-compose \
        -f docker-compose.redis.yml \
        -f docker-compose.service.yml \
        pull \
    || exit 1

    docker-compose \
        -f docker-compose.redis.yml \
        -f docker-compose.service.yml \
        up -d --remove-orphans \
    || exit 1

    docker-compose \
        -f docker-compose.redis.yml \
        -f docker-compose.service.yml \
        logs -f shop-with-redis \
    || exit 1
elif [[ "$1 $2" == "docker restart" ]]; then
    docker-compose \
        -f docker-compose.redis.yml \
        -f docker-compose.service.yml \
        restart $3 \
    || exit 1
elif [[ "$1 $2" == "docker delete" ]]; then
    docker-compose \
        -f docker-compose.redis.yml \
        -f docker-compose.service.yml \
        down -v \
    || exit 1
else
    printf "%s" "Usage: shop-with-postgres"
    printf "\n"
    printf "%s\n" "Management Commands:"
    printf "\t%s\t%s\n" "docker login" "Login to registry.gitlab.com"
    printf "\t%s\t%s\n" "docker build" "Build docker image"
    printf "\t%s\t%s\n" "docker push" "Push docker image"
    printf "\t%s\t%s\n" "docker run" "Run docker-compose up"
    printf "\t%s\t%s\n" "docker delete" "Run docker-compose down"
fi

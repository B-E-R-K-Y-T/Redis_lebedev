import groovy.transform.CompileStatic
import io.tswf.groovy.bettergroovy.transforms.annotationgstrings.GStringsInAnnotations
import io.tswf.groovy.bettergroovy.transforms.directnamedargs.DirectNamedArgsCall
import io.tswf.groovy.bettergroovy.transforms.namedvariantdefaults.NamedVariantDefaults
import io.tswf.groovy.bettergroovy.transforms.extensions.SameSourceSetExtensionMethods
import io.tswf.groovy.bettergroovy.transforms.extensions.SilentStaticTypeChecker

withConfig(configuration) {
    ast(SilentStaticTypeChecker)

    if (getBooleanProperty("groovycOptionSameSourceExtensions")) {
        ast(SameSourceSetExtensionMethods)
    }

    if (getBooleanProperty("groovycOptionGlobalGStringInAnnotationsTransform")) {
        ast(GStringsInAnnotations)
    }

    if (getBooleanProperty("groovycOptionGlobalNamedVariantsDirectCallsTransform")) {
        ast(DirectNamedArgsCall)
    }

    if (getBooleanProperty("groovycOptionGlobalNamedVariantsDefaultsTransform")) {
        ast(NamedVariantDefaults)
    }

    if (getBooleanProperty("groovycOptionGlobalCompileStaticTransform")) {
        ast(CompileStatic)
    }
}

boolean getBooleanProperty(String featureName) {
    def stringProperty = getStringProperty(featureName)
    if (stringProperty != null) {
        return stringProperty.equalsIgnoreCase("true")
    }

    return null
}

String getStringProperty(String propertyName) {
    return System.getProperty(propertyName)
}
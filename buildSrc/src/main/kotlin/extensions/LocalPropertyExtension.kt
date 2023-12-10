
package extensions

import org.gradle.api.Project
import java.util.Properties

private const val LOCAL_PROPERTIES_FILE_NAME = "local.properties"

/**
 * Obtain property declared on `$projectRoot/local.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getLocalProperty(propertyName: String): String? {
    val localProperties = Properties().apply {
        val localPropertiesFile = project.rootProject.file(LOCAL_PROPERTIES_FILE_NAME)
        if (localPropertiesFile.exists()) {
            load(localPropertiesFile.inputStream())
        }
    }

    return localProperties.getProperty(propertyName)
}


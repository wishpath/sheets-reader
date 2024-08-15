plugins {
    id("java")
}

group = "org.sa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Google Sheets API: This is the core library to interact with the Google Sheets API.
    implementation("com.google.apis:google-api-services-sheets:v4-rev581-1.25.0")

    // Google Client Library: This is the Google API Client Library that provides basic HTTP client functionality.
    implementation("com.google.api-client:google-api-client:1.30.10")

    // OAuth2 Client Library: This library handles OAuth2 authentication to securely access Google services.
    implementation("com.google.auth:google-auth-library-oauth2-http:0.21.0")

    // Jackson JSON Processor (for JSON parsing): This is a JSON processor used by the Google API Client Library to parse JSON data.
    implementation("com.google.http-client:google-http-client-jackson2:1.40.1")

    implementation("com.google.api-client:google-api-client:1.34.1")
    implementation("com.google.oauth-client:google-oauth-client-jetty:1.34.1")
    implementation("com.google.apis:google-api-services-sheets:v4-rev614-1.25.0")
}

tasks.test {
    useJUnitPlatform()
}
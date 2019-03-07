# Secretsmanager Extension

The Secrets Manager Connector allows you to fetch secret values hosted in Amazon's Secrets Manager. Right now, this is designed to be used in an environment where the AWS Access Keys and Secret Keys are already set and in place.

To use this, add this dependency to your application's pom.xml:

```
<groupId>io.greenhouse</groupId>
<artifactId>secretsmanager</artifactId>
<version>0.0.1</version>
<classifier>mule-plugin</classifier>
```

Next, drag the Secrets Manager connector in to your workflow. You can optionally set a prefix for all keys to use by setting a global configuration for the Connector. You then specify the key name that you want to retrieve the secret value for. For example, if your configured prefix is `company_name` and the key name is `secret_password`, the key that would be fetched out of Amazon AWS' Secrets Manager is `company_name_secret_password`.

Additionally, you can set the "Simulated" flag to true and the "Simulated Value" to whatever test value that you want. This will make the connector return that value instead of making the AWS call to get the secret value. The Simulated flag can be set with a DataWeave expression, allowing you to choose when you do and don't want to fetch the value out of the AWS vault.

package com.proalpha.codeartifact

class CodeartifactCredentialsException extends RuntimeException {
    CodeartifactCredentialsException(Throwable cause) {
        super(cause)
    }

    @Override
    String getMessage() {
        return """\
❌ AWS SDK failed to load credentials.

💡 Suggestions to fix it:
  - Renew your AWS SSO session:
    aws sso login
  - Or set the required environment variables:
    export AWS_ACCESS_KEY_ID=<your-access-key>
    export AWS_SECRET_ACCESS_KEY=<your-secret-access-key>
  - Or check your profile
    export AWS_PROFILE=<my-profile>
  - Or reconfigure sso
    aws sso configure

🔍 SDK tried the following providers:
  - System properties
  - Environment variables
  - Web identity (e.g., IAM roles for service accounts)
  - AWS profile (from ~/.aws/credentials)
  - ECS/Container credentials
  - EC2 instance profile (IMDS)

🛠  For debugging, try running: aws sts get-caller-identity

📄 Root cause from AWS SDK:
   ${cause?.message ?: "Unknown SDK error"}
"""
    }

}


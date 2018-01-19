curl -v -d '{}' 'https://u80lf760ri.execute-api.us-east-1.amazonaws.com/prod/helloworldjar'

# logs here:
# https://us-east-1.console.aws.amazon.com/cloudwatch/home?region=us-east-1#logEventViewer:group=/aws/lambda/helloworldjar;stream=2018/01/15/%5B$LATEST%5D5aaee9a723ef445eaa24849a123d527c



# upload jar
aws configure
us-east-1
aws lambda  update-function-code --function-name helloworldjar --zip-file fileb://target/aws-lambda-hello-world-1.0-SNAPSHOT.jar

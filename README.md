# account-service
Account Service

## Controlling Services
### API-endpoints
```
POST - http://http://localhost:8080/accounts/create @ResponseBody(#ref Account)
```
### Account.json
```
{
    "id" : "101",
    "accountname" : "CHecking Account-101",
    "type" : "Checking"
}

```
```
It has data.sql which will Insert the Records on Server Start up
```

```
I have added Swagger 3: http://localhost:8080/swagger-ui/
You can use Swagger UI to get the API details.
```

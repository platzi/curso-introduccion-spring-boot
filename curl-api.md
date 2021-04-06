**Guardar usuario**

curl --location --request POST 'localhost:8081/app/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "michael",
    "email": "michael2.test@mail.com",
    "birthDate": "2021-04-25"
}'

**Obtener usuarios**

curl --location --request GET 'localhost:8081/app/users'

**Actualizar usuario**

curl --location --request PUT 'localhost:8081/app/users/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "michael",
    "email": "michael2.111@mail.com",
    "birthDate": "2021-04-26"
}'

**Eliminar usuario**

curl --location --request DELETE 'localhost:8081/app/users/4' \
--data-raw ''
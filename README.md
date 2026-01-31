# Login (Webbshop)

## Arkitektur

### Controllers
ProductController:
- `/`
- `/prodcut/<productID>`
- `/prodcut/add?title=<productTile>&info=<productInfo>&cost=<productCost>&img=<prdocutImg>` krävs `AU_Admin` permission

AuthController:
- `/auth/register`
- `/auth/login`

ErrorController:
- `/error`

### @Service
- AuthService:
  - `isAuthenticated()`
- ProductService:
  - `findProductByID(String productID)`
  - `getAllProducts()`
  - `createNewProdcut(ProductModel pModel)`
-  RegisterService:
    - `registerNewUserAccount (RegisterDto user)`
- UserDetailServiceImpl:
  - `loadUserByUsername(String email)` använder sig av email istället för användarnamn

### Repository
-  UserRepository
-  ProductRepository

### Model
- UserModel
- RegisterDto
- ProductModel

## Säkerhet
SecuriyConfig hanterar vad man har tillgång till som t.ex. en oinloggad använder har ej tillgång till `/cart` eller `/logout` genom att kollar if användaren är `authenticated()` och så använder applikation sig av ```sec:authorize="isAuthenticated()"``` för vissa knappar bara för det som är inloggad och applikation använder sig också av `@PreAuthorize("hasAuthority('AU_Admin')")` på route `/product/add`

## Användning
Man kommer behöva
- Mysql
- Java 17
- Maven

Och sen konfigrerar anslutning till mysql databasen
```java
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/login
spring.datasource.username=<Mysql Användanamn>
spring.datasource.password=<Mysql Password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

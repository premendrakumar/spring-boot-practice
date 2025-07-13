Zaroor Prem bhai! Yahaan par **GitHub OAuth2 login** ko Spring Boot application mein kaise integrate karte hain uska complete example hai:

---

## ✅ Step-by-Step: Spring Boot + GitHub OAuth2 Login

### 🧱 1. **GitHub App Create karo:**

* Visit: [https://github.com/settings/developers](https://github.com/settings/developers)
* Click **"New OAuth App"**

    * **App name**: YourAppName
    * **Homepage URL**: `http://localhost:8080`
    * **Authorization callback URL**: `http://localhost:8080/login/oauth2/code/github`
* Save it
* Note down:

    * `Client ID`
    * `Client Secret`

---

### 🧾 2. `application.yml` configuration

```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          github:
            client-id: YOUR_GITHUB_CLIENT_ID
            client-secret: YOUR_GITHUB_CLIENT_SECRET
            scope: read:user,user:email
        provider:
          github:
            authorization-uri: https://github.com/login/oauth/authorize
            token-uri: https://github.com/login/oauth/access_token
            user-info-uri: https://api.github.com/user
            user-name-attribute: login
```

---

### 📦 3. `pom.xml` dependencies (Spring Boot 3+)

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
</dependencies>
```

---

### 🧠 4. Create a simple Controller

```java
@RestController
public class HomeController {

  @GetMapping("/")
  public String home(@AuthenticationPrincipal OAuth2User principal) {
    return "Welcome, " + principal.getAttribute("login");
  }

  @GetMapping("/secured")
  public String secured(@AuthenticationPrincipal OAuth2User principal) {
    return "Secure Page for: " + principal.getAttribute("login");
  }
}
```

---

### 🔐 5. Enable Security Config (Optional)

By default Spring Boot secures everything except `/`, but if you want custom control:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/").permitAll()
        .anyRequest().authenticated()
      )
      .oauth2Login(); // GitHub login
    return http.build();
  }
}
```

---

### 🏁 6. Run & Test

* Run your app: `http://localhost:8080`
* Visit `/secured`
* You'll be redirected to GitHub login
* After login, you’ll return to your app with user info

---

Bhai, agar tu `Spring Boot 2.x` use kar raha ho toh bhi same config chalega. Agar chaahe toh login ke baad dashboard page bhi redirect karwa sakte hain.

Batao, deploy bhi karna hai ya bas local testing ke liye chahiye?

package com.sha.springbootmicroservice1product.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//api/product erişim yapmak istiyor ama credential lazım httpFilterlara gelen isteklerin headerlerı kontrol edilir
// username ve password bilgilerini denetler farklı roller için farklı yetkiler
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable(); //cross side request forgery session kullanarak saldırı cookilere ulaşır
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //bellek için kimlik doğrulama

        PasswordEncoder encoder = new BCryptPasswordEncoder(); //güçlü bir hashing sağlar şifreleri açık gösterme
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser(SECURE_KEY_USERNAME)
                .password(encoder.encode(SECURE_KEY_PASSWORD)) //clear text is not secure
                .roles("USER");
    }
}

//package com.casestudy.main.configuration;
//
//import com.casestudy.main.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
////Sử dụng thuật toán Bcrypt để mã hóa password.
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        //Khi tạo mới tài khoản thì cần mã hóa mật khẩu trước khi lưu vào DB
////        String password = bCryptPasswordEncoder.encode("123123");
//        return bCryptPasswordEncoder;
//    }
//
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////
////        // Sét đặt dịch vụ để tìm kiếm User trong Database.
////        // Và sét đặt PasswordEncoder.
////        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////
////    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//
//    }
//
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable();
//
//        // Các trang không yêu cầu login
//
//
//
//        // Cấu hình cho Login Form.
//        http.authorizeRequests().and().formLogin()//
//                // Submit URL của trang login
////                .loginProcessingUrl("/j_spring_security") // Submit URL
////                .loginPage("/login")//
//                .defaultSuccessUrl("/")//
//                .failureUrl("/login?error=true")//
//                .usernameParameter("username")//
//                .passwordParameter("password")
//                .and().authorizeRequests().antMatchers("/", "/login", "/logout","/static/assets/**","/**/*.js", "/**/*.css").permitAll()
//// form mau
//                .and().authorizeRequests().antMatchers("/customer/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//
//
//                // Cấu hình cho Logout Page.
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
//
//        // Cấu hình Remember Me.
//        http.authorizeRequests().and() //
//                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
//                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
//
//    }
//
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
//        return memory;
//    }
//
//}
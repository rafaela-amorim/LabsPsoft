package usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import usuario.filters.TokenFilter;

@SpringBootApplication
public class UsuarioApplication {

	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		FilterRegistrationBean<TokenFilter> filterRB = new FilterRegistrationBean<TokenFilter>();
		filterRB.setFilter(new TokenFilter());
		filterRB.addUrlPatterns("/auth/usuarios/**");
		return filterRB;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}

}

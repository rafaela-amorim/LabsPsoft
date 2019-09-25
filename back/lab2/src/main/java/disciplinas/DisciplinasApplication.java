package disciplinas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import disciplinas.filters.TokenFilter;

@SpringBootApplication
public class DisciplinasApplication {

	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		FilterRegistrationBean<TokenFilter> filterRB = new FilterRegistrationBean<TokenFilter>();
		filterRB.setFilter(new TokenFilter());
		
		// aqui vao as rotas que precisam de token, para passarem pelo filter
		filterRB.addUrlPatterns("/auth/usuarios", "/disciplinas/*");
		return filterRB;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DisciplinasApplication.class, args);
	}

}

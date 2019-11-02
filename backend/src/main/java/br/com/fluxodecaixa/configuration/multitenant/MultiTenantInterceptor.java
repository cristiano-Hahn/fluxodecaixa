package br.com.fluxodecaixa.configuration.multitenant;

import br.com.fluxodecaixa.domain.model.Usuario;
import br.com.fluxodecaixa.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class MultiTenantInterceptor implements ApplicationListener<AuthenticationSuccessEvent> {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public MultiTenantInterceptor(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {

        String email = authenticationSuccessEvent.getAuthentication().getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        MultiTenantContext.setCurrentTenant(usuario.getEmpresa().getSchema());
    }

}

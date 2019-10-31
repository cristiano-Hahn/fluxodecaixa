package br.com.fluxodecaixa.infrastructure.security;

import br.com.fluxodecaixa.domain.model.Usuario;
import br.com.fluxodecaixa.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);

        if (usuario == null)
            throw new UsernameNotFoundException("Usuário não encontrado!");

        return new UserDetailsImpl(usuario);
    }
}

package com.example.EF.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EF.AuthPackage.AuthResponse;
import com.example.EF.AuthPackage.AuthService;
import com.example.EF.AuthPackage.LoginRequest;
import com.example.EF.AuthPackage.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
/* 
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Verifica si el usuario existe en la base de datos
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndContrasena(loginRequest.getEmail(), loginRequest.getContrasena());

        if (usuario.isPresent()) {
            // Genera el token JWT usando la información del usuario
            String token = jwtTokenUtil.generateToken(usuario.get());

            // Devuelve el usuario autenticado junto con el token
            AuthResponse authResponse = new AuthResponse(token, usuario.get());
            return ResponseEntity.ok(authResponse);
        } else {
            // Devuelve un mensaje de error si las credenciales son incorrectas
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }*/
}

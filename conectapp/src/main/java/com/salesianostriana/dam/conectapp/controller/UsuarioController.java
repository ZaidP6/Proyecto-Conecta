package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CreateUsuarioDto;
import com.salesianostriana.dam.conectapp.dto.GetUsuarioDto;
import com.salesianostriana.dam.conectapp.model.Usuario;
import com.salesianostriana.dam.conectapp.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario/")
@Tag(name = "Usuario", description = "Endpoints para la gestión de usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping()
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un usuario y lo guarda en la base de datos")
    @ApiResponse(responseCode = "201", description = "Usuario creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    public ResponseEntity<Usuario> crear(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos para crear un usuario",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateUsuarioDto.class),
                            examples = @ExampleObject(
                                    name = "Usuario de ejemplo",
                                    value = """
                                        {
                                          "userName": "juanperez",
                                          "password": "123456",
                                          "emailProfesor": "juan@example.com",
                                          "nombreProfesor": "Juan",
                                          "apellidosProfesor": "Pérez",
                                          "telefonoProfesor": "123456789"
                                        }
                                    """
                            )
                    )
            )@RequestBody CreateUsuarioDto nuevoUser){
        Usuario usuario = usuarioService.addNew(nuevoUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de todos los usuarios registrados en la base de datos")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron usuarios en la base de datos")
    public List<GetUsuarioDto> listarUsuarios(){
        return usuarioService.findAll().stream().map(GetUsuarioDto::of).toList();
    }

    @GetMapping("{id}")
    @Operation(summary = "Obtener un usuario por ID", description = "Buscar un usuario por su ID en la base de datos")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public GetUsuarioDto getUserById(@PathVariable Long id) {
        return GetUsuarioDto.of(usuarioService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar un usuario por ID", description = "Edita un usuario existente en la base de datos")
    @ApiResponse(responseCode = "200", description = "Usuario editado correctamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long id, @Valid @RequestBody CreateUsuarioDto usuarioDto) {
        Usuario updatedUsuario = usuarioService.editUserById(usuarioDto, id);
        return ResponseEntity.ok(updatedUsuario);
    }
}

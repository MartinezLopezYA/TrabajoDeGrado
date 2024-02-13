export interface RegistroUsuario {
    idUsuario: number,
    nombreUsuario: string,
    apellidoUsuario: string,
    correoUsuario: string,
    semestre: number,
    contrasena: string,
    fechaNacimiento: Date,
}

export interface RegistroUsuarioModal {
    idUsuario: number,
    nombreUsuario: string,
    apellidoUsuario: string,
    correoUsuario: string,
    semestre: number,
    contrasena: string,
    fechaNacimiento: Date,
    registro: RegistroUsuario
}

export interface RegistroUsuarioActualizar {
    nombreUsuario: string,
    apellidoUsuario: string,
    correoUsuario: string,
    semestre: number,
    contrasena: string,
    fechaNacimiento: Date,
}
package com.example.myapplication;

public class Validador {

    // Validar que tenga al menos Nombre y Apellido (espacio entre medio)
    public static boolean esNombreValido(String nombreCompleto) {
        if (nombreCompleto == null) {
            return false;
        }
        String textoLimpio = nombreCompleto.trim();
        return textoLimpio.contains(" ") && textoLimpio.length() >= 3;
    }

    // Validar RUT con guion obligatorio (ej: 12345678-9)
    public static boolean esRutValido(String rutUsuario) {
        if (rutUsuario == null) {
            return false;
        }
        String rutLimpio = rutUsuario.trim();
        return rutLimpio.contains("-") && rutLimpio.length() >= 8;
    }

    // Validar teléfono chileno con +56 9 y 8 dígitos adicionales
    public static boolean esTelefonoValido(String numeroTelefono) {
        if (numeroTelefono == null) {
            return false;
        }
        String fonoLimpio = numeroTelefono.replace(" ", "").trim();
        // Debe comenzar con +569 y tener exactamente 12 caracteres (ej: +56912345678)
        if (!fonoLimpio.startsWith("+569") || fonoLimpio.length() != 12) {
            return false;
        }
        return true;
    }

    // Validar correo con @ y dominio (.com, .cl, etc.)
    public static boolean esCorreoValido(String correoEmail) {
        if (correoEmail == null) {
            return false;
        }
        String correoLimpio = correoEmail.trim().toLowerCase();
        if (!correoLimpio.contains("@")) {
            return false;
        }
        return correoLimpio.endsWith(".com") || correoLimpio.endsWith(".cl") || correoLimpio.endsWith(".org") || correoLimpio.endsWith(".net");
    }

    // Validar clave: mínimo 5 caracteres, 1 mayúscula, 1 número y 1 carácter especial
    public static boolean esClaveValida(String claveAcceso) {
        if (claveAcceso == null || claveAcceso.length() < 5) {
            return false;
        }
        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        for (int i = 0; i < claveAcceso.length(); i++) {
            char c = claveAcceso.charAt(i);
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (!Character.isLetterOrDigit(c)) {
                tieneEspecial = true;
            }
        }

        return tieneMayuscula && tieneNumero && tieneEspecial;
    }
}

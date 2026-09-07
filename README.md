# TaskMaster

Proyecto de aplicación móvil para gestión de tareas diarias desarrollado en Java para Android Studio.

## Descripción

TaskMaster es una aplicación que permite a los usuarios registrarse, iniciar sesión y administrar sus tareas diarias. Cuenta con pantallas de bienvenida, menú principal con estadísticas de progreso, formulario para agregar tareas y lista interactiva.

## Estructura del Código

El proyecto está organizado en las siguientes clases:

- **MainActivity.java**: Pantalla de inicio de sesión.
- **RegisterActivity.java**: Formulario de registro de usuarios.
- **WelcomeActivity.java**: Pantalla de bienvenida.
- **HomeActivity.java**: Menú principal con resumen de estadísticas y lista de tareas.
- **AddTaskActivity.java**: Formulario para crear una nueva tarea.
- **Usuario.java**: Clase modelo para representar a los usuarios.
- **Tarea.java**: Clase modelo para representar a las tareas.
- **Validador.java**: Funciones de validación de formulario (Nombre, RUT, Teléfono, Correo y Contraseña).
- **Datos.java**: Repositorio en memoria que utiliza ArrayList para almacenar datos.
- **TaskAdapter.java**: Adaptador para mostrar la lista de tareas en el RecyclerView.

## Elementos y Componentes Utilizados

- **Layouts**: ConstraintLayout, LinearLayout, TableLayout.
- **Widgets**: CheckBox, RadioButton, ProgressBar, RatingBar, ImageView.
- **Contenedores**: Spinner, RecyclerView, ScrollView, CardView.

## Usuario de Prueba

Para probar el inicio de sesión directo:
- **Correo**: admin@santotomas.cl
- **Contraseña**: Admin123!

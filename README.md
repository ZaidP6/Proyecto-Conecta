# Proyecto-Conecta
## INTRODUCCIÓN
Con la nueva Ley de Formación Profesional se ha incrementado el número de horas que el alumnado de FP debe pasar en la empresa, y ya no basta con la clásica Formación en Centros de Trabajo del 2º curso, sino que deben realizar al menos una estancia formativa en 1º. Esto ha supuesto que los centros educativos deban aumentar el número de empresas con las que colaboran. La colaboración entre centros educativos y empresas desempeña un papel clave en la formación de futuros profesionales. Esta sinergia no solo permite que los estudiantes adquieran experiencia práctica en entornos reales de trabajo, sino que también facilita que las empresas identifiquen y formen talento adaptado a sus necesidades
La comunicación entre estas dos partes puede presentar desafíos, como la falta de un canal centralizado y eficiente para gestionar propuestas, solicitudes y seguimiento de prácticas. Por ello, se propone el desarrollo de una herramienta que facilite y mejore la interacción entre profesores de formación profesional y empresas colaboradoras.
El objetivo de este proyecto es diseñar e implementar una plataforma que permita:
Gestionar de forma centralizada las ofertas de prácticas ofrecidas por las empresas.
Proporcionar a los profesores un medio sencillo para coordinar con las empresas.
Ofrecer un sistema para realizar el seguimiento de los alumnos durante su estancia en la empresa.
Este proyecto no solo ayudará a mejorar la comunicación, sino que también sentará las bases para una colaboración más sólida y efectiva entre los centros de formación profesional y las empresas, en beneficio tanto de los estudiantes como del tejido empresarial local.
## PRODUCTO FINAL
El producto final de este proyecto será una API REST implementada con Spring Boot 3 utilizando las siguientes tecnologías:
- Spring Data JPA y Postgresql para la persistencia de información.
- OpenAPI, Swagger y Springdoc para generar la documentación.
- Postman para poder testear la API REST.
- 
## FUNCIONALIDADES

La API desarrollada con Spring Boot tendrá las siguientes funcionalidades:

Los diferentes endpoints necesarios para dar funcionalidad a las distintas pantallas de la aplicación cliente. Para poder realizar bien esta parte sería bueno realizar un prototipo de la posible aplicación cliente. Algunas pistas podrían ser:
- Operaciones CRUD sobre los datos maestros: Familias profesionales, Títulos, Cursos, Profesorado (docencia), Empresas, Trabajadores, Convocatorias, …
- Registro de contactos entre un profesor y una empresa.
- Consultas como:
  - Todas las comunicaciones con una empresa.
  - Todas las comunicaciones de una familia profesional.
  - Las comunicaciones de un profesor/a.
  - La gestión de la demanda de alumnado
  - …
- Cada endpoint estará documentado, de forma que se podrá consultar esta documentación con Swagger.
- Esta aplicación será segura, y no podrá ser utilizada por usuarios no registrados, salvo las peticiones de registro y de login.
- La API gestionará convenientemente los errores, sobre todo los de validación, presentando al usuario una estructura de mensaje común, que se tratará desde la aplicación cliente para informar al usuario de posibles errores de entrada de datos o asociados a la lógica de negocio.
- El modelo de datos no se podrá trasladar usando fetching de tipo EAGER en las asociaciones XXXXToMany.
- Las políticas de borrado serán definidas de acuerdo a lo que se estime más oportuno para el funcionamiento de la aplicación.
- Todas las operaciones de acceso a los datos que realicen los controladores las harán a través de los servicios.
- Además, en los métodos de los controladores solamente se podrán realizar operaciones de transformación de entidades a DTO, nunca a la inversa. Por tanto, los métodos de los servicios pueden recibir un DTO como argumento, pero nunca tendrán un DTO como tipo de retorno.
- La base de datos que se usará será Postgresql y es conveniente tener dos perfiles de trabajo: dev para desarrollo y prod para producción.

## Consultas

- Para la comprobación de todos las personas que son profesores que a su vez deben ser usuarios:
    """
      SELECT * 
      FROM PERSONA p
      JOIN PROFESOR pr ON p.ID = pr.ID
      JOIN USUARIO u ON pr.ID = u.PROFESOR_ID;
    """

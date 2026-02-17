Sistema Hospital San José

Este proyecto implementa un sistema básico para el Hospital San José usando Java y Programación Orientada a Objetos.

El sistema se basa en la clase abstracta Persona, de la cual heredan Medico y Paciente. Además, se implementa la interfaz ICirujano para representar el comportamiento de un médico cirujano.

Conceptos aplicados

Abstracción: Persona es una clase abstracta con el método abstracto presentarse().

Herencia: Medico y Paciente heredan de Persona. MedicoCirujano hereda de Medico.

Interfaces: ICirujano es implementada por MedicoCirujano.

Polimorfismo: se almacenan objetos en una lista común List<Persona> y se recorre para ejecutar presentarse() según el tipo real.

Lógica: se usan ciclos, condicionales y switch según lo solicitado.

Funcionalidades

Medico: revisa pacientes con un ciclo y asigna prioridad usando switch.

Paciente: verifica su presupuesto con if y muestra síntomas.

MedicoCirujano: valida el estado del quirófano usando boolean y decide si puede operar.

Atencion: procesa el ingreso del paciente y asigna pabellón según la EPS.

Simulación

La clase principal se llama gestionHospital y simula un día normal en el hospital creando:

4 médicos

4 médicos cirujanos

12 pacientes

Luego se ejecutan los comportamientos solicitados en consola.

Estructura del proyecto
/src
  Persona.java
  Medico.java
  MedicoCirujano.java
  Paciente.java
  ICirujano.java
  Atencion.java
  gestionHospital.java

/uml
  diagrama.puml

  Autores
  Karolay Garcia Vasquez
  Elkin Alzate
  Santiago Sanchez Sanchez

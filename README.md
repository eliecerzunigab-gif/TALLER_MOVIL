# Proyecto: Aplicación de Despacho para Distribuidora de Alimentos

Este documento contiene los requerimientos, historias de usuario y otros artefactos de planificación para el desarrollo de la aplicación de despacho a domicilio.

## 1. Requerimientos

### Requerimientos Funcionales (RF)

- **RF01:** El sistema debe permitir a los usuarios registrarse en la aplicación utilizando sus cuentas de Google (Gmail).
- **RF02:** El sistema debe permitir a los usuarios iniciar y cerrar sesión.
- **RF03:** El sistema debe mostrar un catálogo de productos disponibles para la compra.
- **RF04:** El sistema debe permitir a los usuarios agregar productos a un carrito de compras.
- **RF05:** El sistema debe permitir a los usuarios visualizar y modificar el contenido de su carrito de compras.
- **RF06:** El sistema debe calcular automáticamente el costo de despacho basado en el monto total de la compra y la distancia en kilómetros.
- **RF07:** El sistema debe aplicar las siguientes reglas de negocio para el despacho:
    - **Gratis:** para compras sobre $50,000 CLP dentro de un radio de 20 km.
    - **Tarifa Normal:** $150 CLP por kilómetro para compras entre $25,000 y $49,999 CLP.
    - **Tarifa Alta:** $300 CLP por kilómetro para compras menores a $25,000 CLP.
- **RF08:** El sistema debe limitar los despachos a un radio máximo de 20 km desde la distribuidora.
- **RF09:** El sistema debe permitir al usuario confirmar la compra y proceder a un checkout (simulado).

### Requerimientos No Funcionales (RNF)

- **RNF01 (Rendimiento):** La aplicación debe responder a las interacciones del usuario en menos de 2 segundos.
- **RNF02 (Usabilidad):** La interfaz de usuario debe ser intuitiva y fácil de usar para personas con conocimientos básicos de tecnología móvil.
- **RNF03 (Seguridad):** La autenticación con Google debe ser segura y proteger los datos del usuario.
- **RNF04 (Compatibilidad):** La aplicación debe ser compatible con dispositivos móviles que ejecuten versiones recientes de Android o iOS (según la plataforma de desarrollo).
- **RNF05 (Disponibilidad):** El servicio debe estar disponible el 99% del tiempo.

## 2. Historias de Usuario

**HU01: Registro de Usuario**
- **Como** un cliente nuevo,
- **quiero** registrarme en la aplicación usando mi cuenta de Gmail,
- **para** poder realizar compras de forma rápida y segura.
- **Criterios de Aceptación:**
    - Debe existir un botón "Registrarse con Google".
    - Al hacer clic, se debe redirigir al flujo de autenticación de Google.
    - Tras una autenticación exitosa, el usuario debe ser redirigido a la pantalla principal de la aplicación ya logueado.

**HU02: Cálculo de Costo de Despacho**
- **Como** un cliente que está finalizando su compra,
- **quiero** que el sistema calcule automáticamente el costo de mi despacho,
- **para** saber el monto total a pagar antes de confirmar el pedido.
- **Criterios de Aceptación:**
    - Si mi compra es de $50,001, el costo de despacho debe ser $0.
    - Si mi compra es de $30,000 y la distancia es de 10 km, el costo de despacho debe ser $1,500.
    - Si mi compra es de $20,000 y la distancia es de 15 km, el costo de despacho debe ser $4,500.
    - Si la distancia es mayor a 20 km, el sistema debe mostrar un mensaje indicando que no hay cobertura.

**HU03: Visualizar Productos**
- **Como** un cliente,
- **quiero** ver un listado de todos los productos disponibles con su nombre y precio,
- **para** poder decidir qué quiero comprar.
- **Criterios de Aceptación:**
    - La lista de productos debe ser clara y legible.
    - Cada producto en la lista debe tener un botón para "Agregar al carrito".

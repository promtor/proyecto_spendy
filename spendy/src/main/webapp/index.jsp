<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Spendy Backend - Pruebas</title>
    <script>
        const contextPath = '<%= request.getContextPath() %>';
        // Variable global para guardar el token
        let authToken = null;
      
        async function callApi(path, method, payload) {
          try {
            const url = path.startsWith('/api') ? contextPath + path : path;
            const options = { method, headers: {} };
      
            // Si tenemos token, lo enviamos en el header
            if (authToken) {
              options.headers['Authorization'] = 'Bearer ' + authToken;
            }
      
            if (payload) {
              options.headers['Content-Type'] = 'application/json';
              options.body = JSON.stringify(payload);
            }
      
            const res = await fetch(url, options);
            const text = await res.text();
            document.getElementById('resultado').textContent = text;
      
            // Si es login y responde con token, lo guardamos
            if (path === '/api/login' && res.ok) {
              const json = JSON.parse(text);
              authToken = json.token;
              document.getElementById('resultado').textContent += '\n\nToken guardado.';
            }
          } catch (err) {
            document.getElementById('resultado').textContent = 'Error: ' + err;
          }
        }
      </script>
      
</head>

<body>
    <h1>Spendy Backend - Panel de Pruebas</h1>
    <div id="resultado" style="white-space: pre-wrap; border: 1px solid #ccc; padding: 10px; margin-bottom: 20px;">
    </div>

    <!-- Registro de Usuario -->
    <fieldset>
        <legend>Registro de Usuario</legend>
        Nombre: <input id="regNombre" />
        Correo: <input id="regCorreo" />
        Password: <input type="password" id="regPassword" />
        <button
            onclick="callApi('/api/usuarios','POST',{nombre: regNombre.value, correo: regCorreo.value, password: regPassword.value})">
            Registrar
        </button>
    </fieldset>

    <!-- Login -->
    <fieldset>
        <legend>Login</legend>
        Correo: <input id="loginCorreo" />
        Password: <input type="password" id="loginPassword" />
        <button
            onclick="callApi('/api/login','POST',{correo: loginCorreo.value, password: loginPassword.value})">
            Login
        </button>
    </fieldset>

    <!-- Registrar Gasto -->
    <fieldset>
        <legend>Registrar Gasto</legend>
        UsuarioId: <input id="gastoUsuario" />
        Fecha (yyyy-MM-dd): <input id="gastoFecha" />
        Importe: <input id="gastoImporte" />
        CategoriaId: <input id="gastoCat" />
        Descripción: <input id="gastoDesc" />
        Latitud: <input id="gastoLat" />
        Longitud: <input id="gastoLon" />
        <button onclick="callApi('/api/gastos','POST',{
            usuarioId: parseInt(gastoUsuario.value),
            fecha: gastoFecha.value,
            importe: parseFloat(gastoImporte.value),
            categoriaId: parseInt(gastoCat.value),
            descripcion: gastoDesc.value,
            latitud: parseFloat(gastoLat.value),
            longitud: parseFloat(gastoLon.value)
        })">Añadir Gasto</button>
    </fieldset>

    <!-- Listar Gastos -->
    <fieldset>
        <legend>Listar Gastos</legend>
        <button onclick="callApi('/api/gastos','GET')">Listar</button>
    </fieldset>

    <!-- Buscar Gastos -->
    <fieldset>
        <legend>Buscar Gastos</legend>
        Consulta: <input id="busqGasto" />
        <button onclick="callApi('/api/gastos/buscar?q='+encodeURIComponent(busqGasto.value),'GET')">Buscar</button>
    </fieldset>

    <!-- Filtrar Gastos -->
    <fieldset>
        <legend>Filtrar Gastos</legend>
        Desde: <input id="fDesde" placeholder="yyyy-MM-dd" />
        Hasta: <input id="fHasta" placeholder="yyyy-MM-dd" />
        Mínimo: <input id="fMin" />
        Máximo: <input id="fMax" />
        CategoriaId: <input id="fCat" />
        <button onclick="{
            const params = [];
            if (fDesde.value) params.push('desde='+fDesde.value);
            if (fHasta.value) params.push('hasta='+fHasta.value);
            if (fMin.value) params.push('min='+fMin.value);
            if (fMax.value) params.push('max='+fMax.value);
            if (fCat.value) params.push('categoria='+fCat.value);
            callApi('/api/gastos/filtro?'+params.join('&'),'GET');
        }">Filtrar</button>
    </fieldset>

    <!-- Gráficos de Gastos -->
    <fieldset>
        <legend>Gráficos Mensuales</legend>
        <button onclick="callApi('/api/graficos','GET')">Obtener Datos Gráficos</button>
    </fieldset>

    <!-- Mapa de Gastos -->
    <fieldset>
        <legend>Mapa de Gastos</legend>
        <button onclick="callApi('/api/mapa','GET')">Ver Mapa</button>
    </fieldset>

    <!-- Registrar Ingreso -->
    <fieldset>
        <legend>Registrar Ingreso</legend>
        UsuarioId: <input id="ingUsuario" />
        Fecha: <input id="ingFecha" placeholder="yyyy-MM-dd" />
        Importe: <input id="ingImporte" />
        Descripción: <input id="ingDesc" />
        Fuente: <input id="ingFuente" />
        <button onclick="callApi('/api/ingresos','POST',{
            usuarioId: parseInt(ingUsuario.value),
            fecha: ingFecha.value,
            importe: parseFloat(ingImporte.value),
            descripcion: ingDesc.value,
            fuente: ingFuente.value
        })">Añadir Ingreso</button>
    </fieldset>

    <!-- Listar Ingresos -->
    <fieldset>
        <legend>Listar Ingresos</legend>
        <button onclick="callApi('/api/ingresos','GET')">Listar Ingresos</button>
    </fieldset>

    <!-- Resumen -->
    <fieldset>
        <legend>Resumen Gastos/Ingresos</legend>
        <button onclick="callApi('/api/resumen','GET')">Obtener Resumen</button>
    </fieldset>

    <!-- Planes de Ahorro -->
    <fieldset>
        <legend>Planes de Ahorro</legend>
        <button onclick="callApi('/api/planes','GET')">Ver Sugerencias</button>
    </fieldset>

    <!-- Tickets -->
    <fieldset>
        <legend>Tickets (OCR)</legend>
        GastoId: <input id="tGastoId" />
        Ruta Imagen: <input id="tImagen" />
        Texto OCR: <input id="tTexto" />
        <button onclick="callApi('/api/tickets','POST',{
            gastoId: parseInt(tGastoId.value),
            imagenPath: tImagen.value,
            textoOCR: tTexto.value
        })">Subir Ticket</button>
        <button onclick="callApi('/api/tickets','GET')">Ver Tickets</button>
        TicketId: <input id="tIdEdit" placeholder="editar/eliminar" />
        New OCR: <input id="tNuevoOCR" />
        <button onclick="callApi('/api/tickets/'+tIdEdit.value,'PUT',{textoOCR: tNuevoOCR.value})">Editar OCR</button>
        <button onclick="callApi('/api/tickets/'+tIdEdit.value,'DELETE')">Borrar Ticket</button>
    </fieldset>

    <!-- Exportar PDF -->
    <fieldset>
        <legend>Exportar PDF</legend>
        <button onclick="callApi('/api/export/pdf','GET')">Exportar a PDF</button>
    </fieldset>

    <!-- Límites y Alertas -->
    <fieldset>
        <legend>Límites y Alertas</legend>
        UsuarioId: <input id="limUsuario" />
        Límite Mensual: <input id="limValor" />
        <button onclick="callApi('/api/limites','POST',{usuarioId: parseInt(limUsuario.value), limiteMensual: parseFloat(limValor.value)})">Establecer Límite</button>
        <button onclick="callApi('/api/alertas','GET')">Ver Alertas</button>
    </fieldset>

    <!-- Compartir Gastos -->
    <fieldset>
        <legend>Compartir Gastos</legend>
        GastoId: <input id="compGastoId" />
        Usuarios JSON: <input id="compUsuarios" placeholder='[1,2,3]' />
        <button onclick="callApi('/api/gastos/compartir','POST',{gastoId: parseInt(compGastoId.value), usuarios: JSON.parse(compUsuarios.value)})">Compartir</button>
    </fieldset>

    <!-- Recuperar Contraseña -->
    <fieldset>
        <legend>Recuperar Contraseña</legend>
        Correo: <input id="recCorreo" />
        <button onclick="callApi('/api/recuperar','POST',{correo: recCorreo.value})">Recuperar</button>
    </fieldset>

    <!-- Configuración -->
    <fieldset>
        <legend>Configuración Usuario</legend>
        UsuarioId: <input id="cfgUsuario" />
        Tema:
        <select id="cfgTema">
            <option value="claro">Claro</option>
            <option value="oscuro">Oscuro</option>
        </select>
        <button onclick="callApi('/api/configuracion','PUT',{usuarioId: parseInt(cfgUsuario.value), tema: cfgTema.value})">Guardar</button>
    </fieldset>
</body>

</html>

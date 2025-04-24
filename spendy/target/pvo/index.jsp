<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Ventas</title>
</head>
<body>
    <h2>Bienvenidos a la página de Gestión de Ventas PVO DE ALEJANDRO</h2>

    <!-- ==================== MÉTODO GET ==================== -->
    <h3> Consultas por método GET</h3>

    <!-- Este formulario hace una petición GET al servlet "getListaArticulos" -->
    <form action="getListaArticulos" method="get">
        <input type="submit" value="Mostrar Lista de Artículos">
    </form>

    <hr>

    <!-- ==================== MÉTODO POST ==================== -->
    <h3>Consultas por método POST</h3>

    <!-- Filtrar usuarios por nombre -->
    <form action="filtrarUsuariosPorNombre" method="post">
        <label>Nombre de usuario:</label>
        <input type="text" name="nombre" required>
        <input type="submit" value="Filtrar Usuarios por Nombre">
    </form>

    <br>

    <!-- Filtrar artículos por nombre -->
    <form action="filtrarArticuloNombre" method="post">
        <label>Nombre del artículo:</label>
        <input type="text" name="nombre" required>
        <input type="submit" value="Filtrar Artículos por Nombre">
    </form>

    <!-- Filtrar artículos por nombre -->
    <h3>Añadir nuevo artículo</h3>
    <form action="addArticulo" method="post">
        <label>ID:</label> <input type="number" name="id" required><br/>
        <label>Nombre:</label> <input type="text" name="nombre" required><br/>
        <label>Descripción:</label> <input type="text" name="descripcion" required><br/>
        <label>Precio:</label> <input type="number" step="0.01" name="precio" required><br/>
        <label>Descuento (decimal entre 0 y 1):</label> <input type="number" step="0.01" name="descuento" required><br/>
        <label>Tipo de prenda:</label>
        <select name="tipo" required>
            <option value="Camiseta">Camiseta</option>
            <option value="Sudadera">Sudadera</option>
            <option value="Chandal">Chandal</option>
        </select><br/><br/>
        <input type="submit" value="Añadir Artículo">
    </form>



    <br><br>
    <p>Los resultados aparecerán en pantalla en formato JSON directamente desde el servidor.</p>
</body>
</html>

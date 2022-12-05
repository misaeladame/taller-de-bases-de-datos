<html>
    <head>
        <title>PHP CRUD</title>
        <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <?php require_once 'process.php'; ?>

        <?php if(isset($_SESSION['mensaje'])): ?>

            <div class="alert alert-<?=$_SESSION['tipo_mensaje']?>">

                <?php
                    echo $_SESSION['mensaje'];
                    unset($_SESSION['mensaje']);
                ?>
            </div>
        <?php endif ?>
        <div class="container">
        <?php

            $mysqli = new mysqli('localhost', 'root', '', 'crud') or die(mysqli_error($mysqli));
            $resultado = $mysqli->query("SELECT * FROM alumnos") or die($mysqli_error);

            ?>

            <div class="row justify-content-center">   
                <table class="table">
                    <thead>
                        <tr>
                            <th>Numero de control</th>
                            <th>Nombre</th>
                            <th colspan="2">Accion</th>
                        </tr>
                    </thead>
            <?php
                while ($row = $resultado->fetch_assoc()): ?>
                    <tr>
                        <td><?php echo $row['alu_nctrl']; ?></td>
                        <td><?php echo $row['alu_nombre']; ?></td>
                        <td>
                            <a href="index.php?editar=<?php echo $row['alu_id']; ?>"
                                class="btn btn-info">Editar</a>
                            <a href="process.php?eliminar=<?php echo $row['alu_id']; ?>"
                                class="btn btn-danger">Eliminar</a>
                        </td>
                    </tr>
                <?php endwhile; ?>
                </table>
            </div>

        <?php

            function pre_r( $array ) {
                echo '<pre>';
                print_r($array);
                echo '</pre>';
            }

        ?>
        <div class="row justify-content-center">
        <form action="process.php" method="POST">
            <input type="hidden" name="alu_id" value="<?php echo $alu_id; ?>">
            <div class="form-group">
                <label>Número de control</label>
                <input type="text" name="alu_nctrl" class="form-control"  
                    value="<?php echo $alu_nctrl; ?>" placeholder="Ingrese su No. de Control">
            </div>
            <div class="form-group">
                <label>Nombre</label>
                <input type="text" name="alu_nombre" class="form-control" 
                    value="<?php echo $alu_nombre; ?>" placeholder="Ingrese su nombre">
            </div>
            <div class="form-group">
            <?php
            if ($actualizar == true):
            ?>
                <button type="submit" class="btn btn-info" name="actualizar">Actualizar</button>
            <?php else: ?>
                <button type="submit" class="btn btn-primary" name="guardar">Guardar</button>
            <?php endif; ?>
            </div>
        </form>
        </div>
        </div>
    </body>
</html>
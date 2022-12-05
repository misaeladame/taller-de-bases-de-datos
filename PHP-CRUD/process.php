<?php

session_start();

$mysqli = new mysqli('localhost', 'root', '', 'crud') or die(mysqli_error($mysqli));

$alu_id = 0;
$actualizar = false;
$alu_nctrl = '';
$alu_nombre = '';

if(isset($_POST['guardar'])) {
    $alu_nctrl = $_POST['alu_nctrl'];
    $alu_nombre = $_POST['alu_nombre'];

    $mysqli->query("INSERT INTO alumnos (alu_nctrl, alu_nombre) 
                    VALUES ('$alu_nctrl', '$alu_nombre')") or 
            die($mysqli->error);
    
    $_SESSION['mensaje'] = "El registro ha sido agregado";
    $_SESSION['tipo_mensaje'] = "success";

    header("location: index.php");
}

if(isset($_GET['eliminar'])) {
    $alu_id = $_GET['eliminar'];
    $mysqli->query("DELETE FROM alumnos WHERE alu_id=$alu_id") or die($mysqli->error());

    $_SESSION['mensaje'] = "El registro ha sido eliminado";
    $_SESSION['tipo_mensaje'] = "danger";

    header("location: index.php");
}

if(isset($_GET['editar'])) {
    $alu_id = $_GET['editar'];
    $actualizar = true;
    $resultado = $mysqli->query("SELECT * FROM alumnos WHERE alu_id=$alu_id") or die($mysqli->error());
    if($resultado->num_rows) {
        $row = $resultado->fetch_array();
        $alu_nctrl = $row['alu_nctrl'];
        $alu_nombre = $row['alu_nombre'];
    }
}

if(isset($_POST['actualizar'])) {
    $alu_id = $_POST['alu_id'];
    $alu_nctrl = $_POST['alu_nctrl'];
    $alu_nombre = $_POST['alu_nombre'];

    $mysqli->query("UPDATE alumnos SET alu_nctrl='$alu_nctrl', alu_nombre='$alu_nombre' WHERE alu_id=$alu_id") or
            die($mysqli->error);

    $_SESSION['mensaje'] = "El registro ha sido actualizado";
    $_SESSION['tipo_mensaje'] = "warning";

    header("location: index.php");
}
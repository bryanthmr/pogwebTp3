<!DOCTYPE html>
<html>
<head>
    <title>Gestion de la Matrice</title>
</head>
<body>
<h1>Opérations sur la Matrice</h1>
<form action="matrix" method="post">
    <label for="x">X :</label>
    <input type="number" id="x" name="x" min="0" max="9"><br>
    <label for="y">Y :</label>
    <input type="number" id="y" name="y" min="0" max="9"><br>
    <label for="val">Valeur :</label>
    <input type="number" id="val" name="val"><br>
    <input type="submit" value="Mettre à jour la cellule">
</form>
<form action="matrix" method="post">
    <input type="submit" value="Réinitialiser la matrice">
</form>

<a href="matrix">Afficher la matrice complète</a>
</body>
</html>

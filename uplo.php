
<?php
// Date in the past

if(is_uploaded_file($_FILES['userfile']['tmp_name'])) {

    echo "File " . $_FILES['userfile']['name'] . "Upload Successfuly\n";
    move_uploaded_file($_FILES['userfile']['tmp_name'], $_FILES['userfile']['name']);
}
else {
    echo "Filename ".$_FILES['userfile']['tmp_name'];
    print_r($_FILES);



}




?>



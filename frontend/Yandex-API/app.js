addEventListeners();

function eventListeners(){
    document.getElementById("translate-form").addEventListener("submit",translateWord);
    //change
    document.getElementById("language").onchange = function(){
        // arayüz işlemleri
        ui.changeUI();
    }
}
const translate = new Translate(
document.getElementById("word").value,
document.getElementById("language"));

const ui = new UI();

function translateWord(e){

    translate.changeParameters(
    document.getElementById("word").value,
    document.getElementById("language").value);

    translate.translateWord(function(err,response){
        if(err){
            console.log(err);
        }
        else{
            ui.displayTranslate(response);
        }
    });
    e.preventDefault();
}
const form = document.getElementById("film-form");
const titleElement = document.querySelector("#title");
const directorElement = document.querySelector("#director");
const urlElement = document.querySelector("#url");
const cardBody = document.querySelectorAll(".card-body")[1];
const clear = document.getElementById("clear-films");
const ui = new UI();

const storage = new Storage();


eventlisteners();

function eventlisteners(){
    form.addEventListener("submit",addFilm);
    document.addEventListener("DOMContentLoaded",function(){
        let films =storage.getFilmsFromStorage();
        ui.loadAllFilms(films);
    });

    cardBody.addEventListener("click",deleteFilm);
    clear.addEventListener("click",clearAllFilms);
}
function addFilm(e){
    const title = titleElement.value;
    const director = directorElement.value;
    const url = urlElement.value;

    if (title === "" || director === "" || url === ""){
        ui.displayMessages("Tüm Alanları Doldurun...","danger");
    }
    else{
        const newFilm = new Film(title,director,url);
        storage.addfilmToStorage(newFilm);
        ui.addFilmToUI(newFilm);
    }

    ui.clearInputs(titleElement,urlElement,directorElement);

    e.preventDefault();
}
function deleteFilm(e){
    if (e.target.id ==="delete-film"){
        ui.deleteFilmFormUI(e.target);
        storage.deleteFilmFormStorage(e.target.parentElement.previousElementSibling.previousElementSibling.textContent);
        ui.displayMessages("silme işlemi başarılı ","success");
    }
}
function clearAllFilms(){
    if(confirm("emin misiniz?:"))
    {
        ui.clearAllFilmsFromStorage();
        storage.clearAllFilmsFromStorage();
    }
   
}
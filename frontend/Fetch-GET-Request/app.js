class Request
{
    get(url){
        return new Promise((resolve,reject)=>{
        fetch(url)
        .then(response =>response.json())
        .then(data => console.log(data))
        .catch(err => console.log(err));
        })
        
    }
}
const request = new Request();
let albums;
request.get("https://jsonplaceholder.typicode.com/albums")
.then(albums => {

    console.log(albums);
})
.catch(err => console.log(err));

// function getData(data){
//     return new Promise(function(resolve,reject){
//         setTimeout(function(){
//             if (typeof data === "string"){
//                 resolve(data);
//             }
//             else{
//                 reject("Lütfen bir string değer giriniz....");
//             }
        
//         },5000);
//     });
// }



// getData(25)
// .then(response => console.log("Gelen Değer"+ response))
// .catch(function(err){
// console.error(err);
// });


function addTwo(number){
    return new Promise((resolve,reject)=>{
        setTimeout(function(){
            if(typeof number === "number"){
                resolve(number+2);
            }
            else{
                reject(new Error("Lütfen bir sayı giriniz "));
            }
        },3000);
    });
}
addTwo("10")
.then(response => {
    console.log(response);
    return response+2;
}).then(response2 => console.log(response2))
.catch(err => console.error(err));
// 1 catch birden çok then kullanabiliriz - promise chain
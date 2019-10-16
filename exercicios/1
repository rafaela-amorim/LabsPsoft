// closures com mudança de estados

function contador_regressivo(n) {
	let contador = n;	

	return function() {
		if (contador < 0) {
			return null;
		}
		return contador--;
	}

}

let c = contador_regressivo(3);

console.log(c());
console.log(c());
console.log(c());
console.log(c());
console.log(c());
console.log(c());

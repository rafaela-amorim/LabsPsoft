function multiplicador(fator) {
	return (n) => fator * n;
}

let dobro = multiplicador(2);
let triplo = multiplicador(3);

console.log(dobro(9))
console.log(triplo(9))

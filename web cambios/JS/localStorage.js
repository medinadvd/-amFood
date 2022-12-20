export function store(data) { localStorage.setItem("correo", data) }
export function storeShow() { return localStorage.getItem("correo") }
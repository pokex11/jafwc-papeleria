const app = Vue.createApp({
    data() {
        return {
            nombres: [],
            seleccionado: '',
            prefijo: '',
            nombre: '',
            apellido: '',
            token: 'pendiente',
            mensajeError: '',
            actualizando: false
        }
    },
    computed: {
        nombresFiltrados() {
            return this.nombres.filter((n) =>
                n.toLowerCase().startsWith(this.prefijo.toLowerCase())
            )
        },
        botonCrearDeshabilitado() {
            return this.actualizando;
        },
        botonActualizarDeshabilitado() {
            return !this.actualizando;
        }
    },
    watch: {
        seleccionado(nombreCompleto) {
            [this.apellido, this.nombre] = nombreCompleto.toString().split(', ');
        }
    },
    methods: {
        crear() {
            if (this.entradaValida()) {
                const nombreCompleto = `${this.apellido}, ${this.nombre}`
                if (!this.nombres.includes(nombreCompleto)) {
                    this.nombres.push(nombreCompleto)
                    this.nombre = this.apellido = '';
                    mensajeError = '';
                    this.actualizando = false;
                    this.$forceUpdate();
                }
            } else {
                mensajeError = "Por favor ingrese todos los datos para crear la persona.";
            }
        },
        actualizar() {
            if (this.entradaValida() && this.seleccionado) {
                const i = this.nombres.indexOf(this.seleccionado);
                this.nombres[i] = this.seleccionado = `${this.apellido}, ${this.nombre}`;
                this.seleccionado = this.nombre = this.apellido = '';
                mensajeError = '';
                this.actualizando = false;
                this.$forceUpdate();
            } else {
                mensajeError = "Por favor ingrese todos los datos para actualizar la información.";
            }
        },
        eliminar() {
            if (this.seleccionado) {
                const i = this.nombres.indexOf(this.seleccionado);
                this.nombres.splice(i, 1);
                this.seleccionado = this.nombre = this.apellido = '';
                mensajeError = '';
                this.actualizando = false;
            }
        },
        entradaValida() {
            return this.nombre.trim() && this.apellido.trim();
        },
        async obtenerData() {
            const options = {
                method: 'POST',
                body: JSON.stringify({ id: 1 }),
                headers: {
                    'Content-Type': 'application/json'
                    /* , 'Authorization': 'Bearer '+this.token */
                }
            };

            fetch('http://localhost:8081/api/token/', options)
                .then(async (response) => {
                    if (!response.ok) {
                        const error = new Error(response.statusText);
                        error.json = response.json();
                        this.mensajeError = error.message;
                        throw error;
                    } else {
                        const data = await response.json();
                        this.token = data.access;
                        console.log(data);
                    }
                });
        }
    },
    mounted() {
        this.obtenerData();
    }
})

const mountedApp = app.mount('#app');
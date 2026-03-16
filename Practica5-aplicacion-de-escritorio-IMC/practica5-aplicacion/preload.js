const { contextBridge, ipcRenderer } = require('electron');

contextBridge.exposeInMainWorld('api', {
    guardarDatos: (datos) => ipcRenderer.invoke('guardar-datos', datos),
    obtenerDatos: () => ipcRenderer.invoke('obtener-datos'),
    eliminarDatos: (id) => ipcRenderer.invoke('eliminar-datos', id)
});
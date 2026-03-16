const { app, BrowserWindow, ipcMain } = require('electron')
const fs = require('fs').promises;
const path = require('path');

let ventanaPrincipal;
let ventanaHistorial;

const createWindow = () => {
    ventanaPrincipal = new BrowserWindow({
        width: 500,
        height: 500,
        webPreferences: {
            nodeIntegration: false,
            contextIsolation: true,
            preload: path.join(__dirname, 'preload.js')
        }
    });

    ventanaPrincipal.loadFile('formulario.html');
    
    // Manejar apertura de ventana de historial
    ventanaPrincipal.webContents.setWindowOpenHandler(({ url }) => {
        if (url.includes('historial.html')) {
            // Crear nueva ventana para el historial
            ventanaHistorial = new BrowserWindow({
                width: 800,
                height: 600,
                webPreferences: {
                    nodeIntegration: false,
                    contextIsolation: true,
                    preload: path.join(__dirname, 'preload.js')
                }
            });
            
            ventanaHistorial.loadFile('historial.html');
            
            // Cuando cierren la ventana de historial
            ventanaHistorial.on('closed', () => {
                ventanaHistorial = null;
            });
            
            return { action: 'deny' }; // Prevenir que Electron maneje la ventana
        }
        return { action: 'deny' };
    });
};

const getRutaDatos = () => {
    return path.join(app.getPath('userData'), 'datos.json');
};

// Guardar datos
ipcMain.handle('guardar-datos', async (event, nuevosDatos) => {
    try {
        const rutaArchivo = getRutaDatos();
        
        let datos = [];
        try {
            const contenido = await fs.readFile(rutaArchivo, 'utf-8');
            datos = JSON.parse(contenido);
        } catch (error) {
            console.log('Creando nuevo archivo');
        }
        
        const nuevoRegistro = {
            ...nuevosDatos,
            id: Date.now(),
            fecha: new Date().toLocaleString()
        };
        
        datos.push(nuevoRegistro);
        await fs.writeFile(rutaArchivo, JSON.stringify(datos, null, 2));
        
        return { exito: true };
    } catch (error) {
        console.error('Error:', error);
        return { exito: false };
    }
});

// Obtener todos los datos
ipcMain.handle('obtener-datos', async () => {
    try {
        const rutaArchivo = getRutaDatos();
        const contenido = await fs.readFile(rutaArchivo, 'utf-8');
        return JSON.parse(contenido);
    } catch (error) {
        return [];
    }
});

// Eliminar un registro
ipcMain.handle('eliminar-datos', async (event, id) => {
    try {
        const rutaArchivo = getRutaDatos();
        const contenido = await fs.readFile(rutaArchivo, 'utf-8');
        let datos = JSON.parse(contenido);
        
        datos = datos.filter(item => item.id !== id);
        await fs.writeFile(rutaArchivo, JSON.stringify(datos, null, 2));
        
        return { exito: true };
    } catch (error) {
        return { exito: false };
    }
});

app.whenReady().then(() => {
  createWindow()
})
/** @type {import('tailwindcss').Config} */
module.exports = {

    content: [
        './src/**/*.html',
        './src/**/*.js',
        './static/css/**/*.css', // Ajuste para incluir archivos CSS en la carpeta static/css
    ],
    corePlugins: {
        aspectRatio: false,
    },
    plugins: [
        require('@tailwindcss/aspect-ratio'),
        require("@tailwindcss/forms")({
            strategy: 'base', // only generate global styles
            strategy: 'class', // only generate classes
        }),
        require('@tailwindcss/typography'),
    ],
    theme: {
        aspectRatio: {
            1: '1',
            2: '2',
            3: '3',
            4: '4',
        }
    },
    variants: {
        aspectRatio: ['responsive', 'hover']
    }

}
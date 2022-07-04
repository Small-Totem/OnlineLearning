import vue from '@vitejs/plugin-vue'

//解决@问题
const path = require('path');
//解决require问题
import requireTransform from 'vite-plugin-require-transform';

export default {
    base: './',
    plugins: [vue(),
        requireTransform({
            fileRegex: /.js$|.vue$/
        }),
    ],
    optimizeDeps: {
        include: ['schart.js']
    },
    define: {
        'process.env': {}
    }
}

#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_texCoord;
uniform sampler2D u_texture;
uniform float u_pixelSize;

void main() {
    vec2 uv = v_texCoord * u_pixelSize;
    uv = floor(uv) / u_pixelSize;
    gl_FragColor = texture2D(u_texture, uv);
}

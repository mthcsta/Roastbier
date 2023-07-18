function url_path(path) {
    return BASE_URL + path;
}

function redirect(path) {
    window.location.href = url_path(path);
}
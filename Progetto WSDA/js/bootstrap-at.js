
let posts;

function loadDoc() {
    const xml_req = new XMLHttpRequest();
    xml_req.open("GET","xml/post.xml",false);
    xml_req.send();
    posts = xml_req.responseXML.documentElement;
}

function loadPosts() {

    loadDoc();

    let html = "";
    const post = posts.getElementsByTagName("post");

    for (let i = 0; i < post.length; i++) {

        const header = post[i].getElementsByTagName("header")[0];
        const main = post[i].getElementsByTagName("main")[0];
        const footer = post[i].getElementsByTagName("footer")[0];

        html += "" +
            "<div class='container post border-2 border-dark border-bottom p-2'>" +

            "<div class='row post-info'>" +
            "<div class='col-10 tag'>" +
            "<span>" + header.getElementsByTagName("username")[0].innerHTML + "</span>&emsp;" +
            "<span class='small'>" + header.getElementsByTagName("nametag")[0].innerHTML + " &#8729; </span>" +
            "<span class='small'>" + header.getElementsByTagName("date")[0].innerHTML + "</span>" +
            "</div>" +
            "<div class='col-2 text-end'>" +
            "<a href='' class='btn rounded-circle'><i class='bi bi-three-dots'></i></a>" +
            "</div>" +
            "</div>" +

            "<div class='row post-content'>" +
            "<div class='col-1'>"+
            "<img src='" + header.getElementsByTagName("pic")[0].innerHTML +"' class='rounded-circle img-fluid' alt='...'>"+
            "</div>" +

            "<div class='col-11'>" +
            "<p>" + main.getElementsByTagName("body")[0].innerHTML + "</p>";

        if (main.getElementsByTagName("attach")[0]){
            html += "<img src='" + main.getElementsByTagName("attach")[0].innerHTML + "' alt='...' class='img-fluid'>";
        }

        html += "" +
            "</div>"+

            "<div class='col-1'></div>" +

            "<div class='col-11 post_options justify-content-between'>" +
            "<a href='' class='btn rounded-pill'><i class='bi bi-heart'></i>&ensp;" + footer.getElementsByTagName("likes")[0].getAttribute('nLikes') +"</a>" +
            "<a href='' class='btn rounded-pill'><i class='bi bi-chat'></i>&ensp;" + footer.getElementsByTagName("comments")[0].getAttribute('nComments') +"</a>" +
            "<a href='' class='btn rounded-pill'><i class='bi bi-bookmark'></i></a>" +
            "</div>" +
            "</div>" +
            "</div>";
    }

    return html;
}


let posts;

function loadDoc(x) {
    const xml_req = new XMLHttpRequest();
    if (x === 0) {
        xml_req.open("GET", "xml/post.xml", false);
    } else {
        xml_req.open("GET", "xml/post2.xml", false);
    }
    xml_req.send();
    posts = xml_req.responseXML.documentElement;
}

function loadPosts(x) {

    loadDoc(x);

    let html = "";
    const post = posts.getElementsByTagName("post");

    for (let i = 0; i < post.length; i++) {

        const post_id = post[i].getAttribute("id");
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

                    "<div class='col-11' onclick=\"window.location.href='post.html?id=" + post_id + "'\">" +
                        "<p>" + main.getElementsByTagName("body")[0].innerHTML + "</p>";

        if (main.getElementsByTagName("attach")[0]){
            html += "<img src='" + main.getElementsByTagName("attach")[0].innerHTML + "' alt='...' class='img-fluid'>";
        }

        html += "" +
                    "</div>"+

                    "<div class='col-1'></div>" +

                    "<div class='col-11 post_options justify-content-between'>" +
                        "<a href='' class='btn rounded-pill'><i class='bi bi-heart'></i>&ensp;" + footer.getElementsByTagName("likes")[0].getAttribute('nLikes') +"</a>" +
                        "<a href='#" + post_id + "' class='btn rounded-pill' data-bs-toggle='collapse'  role='button' aria-expanded='false' aria-controls='" + post_id + "'><i class='bi bi-chat'></i>&ensp;" + footer.getElementsByTagName("comments")[0].getAttribute('nComments') +"</a>" +
                        "<a href='' class='btn rounded-pill'><i class='bi bi-bookmark'></i></a>" +
                            "<div class='collapse' id='" + post_id + "'>";

        const comment = footer.getElementsByTagName("comment");

        for (let i = 0; i < comment.length; i++) {

            const c_header = comment[i].getElementsByTagName("header")[0];
            const c_main = comment[i].getElementsByTagName("main")[0];
            const c_footer = comment[i].getElementsByTagName("footer")[0];

            html += "" +
                "<div class='container post border-2 border-dark border-top p-2'>" +

                    "<div class='row post-info'>" +
                        "<div class='col-10 tag'>" +
                            "<span>" + c_header.getElementsByTagName("username")[0].innerHTML + "</span>&emsp;" +
                            "<span class='small'>" + c_header.getElementsByTagName("nametag")[0].innerHTML + " &#8729; </span>" +
                            "<span class='small'>" + c_header.getElementsByTagName("date")[0].innerHTML + "</span>" +
                        "</div>" +
                        "<div class='col-2 text-end'>" +
                            "<a href='' class='btn rounded-circle'><i class='bi bi-three-dots'></i></a>" +
                        "</div>" +
                    "</div>" +

                    "<div class='row post-content'>" +
                        "<div class='col-1'>" +
                            "<img src='" + c_header.getElementsByTagName("pic")[0].innerHTML + "' class='rounded-circle img-fluid' alt='...'>" +
                        "</div>" +

                        "<div class='col-11'>" +
                            "<p>" + c_main.getElementsByTagName("body")[0].innerHTML + "</p>";

            if (c_main.getElementsByTagName("attach")[0]) {
                html += "<img src='" + c_main.getElementsByTagName("attach")[0].innerHTML + "' alt='...' class='img-fluid'>";
            }

            html += "" +
                        "</div>" +

                        "<div class='col-1'></div>" +

                        "<div class='col-11 post_options justify-content-between'>" +
                            "<a href='' class='btn rounded-pill'><i class='bi bi-heart'></i>&ensp;" + c_footer.getElementsByTagName("likes")[0].getAttribute('nLikes') + "</a>" +
                            "<a href='#" + post_id + "' class='btn rounded-pill' data-bs-toggle='collapse'  role='button' aria-expanded='false' aria-controls='" + post_id + "'><i class='bi bi-chat'></i>&ensp;" + footer.getElementsByTagName("comments")[0].getAttribute('nComments') + "</a>" +
                            "<a href='' class='btn rounded-pill'><i class='bi bi-bookmark'></i></a>" +
                        "</div>" +
                    "</div>" +
                "</div>";
        }

        html += "" +
                        "</div>" +
                    "</div>" +
                "</div>" +
            "</div>";
    }

    return html;
}

function loadSinglePost() {

    // IN FUTURE THE SCRIPT SEND A SPECIFIC XML REQUEST
    loadDoc(0);


    let single_post;
    let html_post = "";
    let html_comment = "";
    const post = posts.getElementsByTagName("post");
    const id = new URLSearchParams(window.location.search).get("id");

    for (let i = 0; i < post.length; i++)
        if(post[i].getAttribute("id") === id)
            single_post = post[i];

    const post_id = single_post.getAttribute("id");
    const header = single_post.getElementsByTagName("header")[0];
    const main = single_post.getElementsByTagName("main")[0];
    const footer = single_post.getElementsByTagName("footer")[0];

    html_post += "" +
        "<div class='container post p-2'>" +

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
        html_post += "<img src='" + main.getElementsByTagName("attach")[0].innerHTML + "' alt='...' class='img-fluid'>";
    }


    html_post += "" +
                "</div>"+

                "<div class='col-1'></div>" +

                "<div class='col-11 post_options justify-content-between'>" +
                    "<a href='' class='btn rounded-pill'><i class='bi bi-heart'></i>&ensp;" + footer.getElementsByTagName("likes")[0].getAttribute('nLikes') +"</a>" +
                    "<a href='' class='btn rounded-pill'><i class='bi bi-chat'></i>&ensp;" + footer.getElementsByTagName("comments")[0].getAttribute('nComments') +"</a>" +
                    "<a href='' class='btn rounded-pill'><i class='bi bi-bookmark'></i></a>" +
                "</div>" +
            "</div>" +
        "</div>";


    const comment = footer.getElementsByTagName("comment");

    for (let i = 0; i < comment.length; i++) {

        const c_header = comment[i].getElementsByTagName("header")[0];
        const c_main = comment[i].getElementsByTagName("main")[0];
        const c_footer = comment[i].getElementsByTagName("footer")[0];

        html_comment += " " +
            "<div class='container post border-2 border-dark border-top p-2'>" +

            "<div class='row post-info'>" +
            "<div class='col-10 tag'>" +
            "<span>" + c_header.getElementsByTagName("username")[0].innerHTML + "</span>&emsp;" +
            "<span class='small'>" + c_header.getElementsByTagName("nametag")[0].innerHTML + " &#8729; </span>" +
            "<span class='small'>" + c_header.getElementsByTagName("date")[0].innerHTML + "</span>" +
            "</div>" +
            "<div class='col-2 text-end'>" +
            "<a href='' class='btn rounded-circle'><i class='bi bi-three-dots'></i></a>" +
            "</div>" +
            "</div>" +

            "<div class='row post-content'>" +
            "<div class='col-1'>" +
            "<img src='" + c_header.getElementsByTagName("pic")[0].innerHTML + "' class='rounded-circle img-fluid' alt='...'>" +
            "</div>" +

            "<div class='col-11'>" +
            "<p>" + c_main.getElementsByTagName("body")[0].innerHTML + "</p>";

        if (c_main.getElementsByTagName("attach")[0]) {
            html_comment += "<img src='" + c_main.getElementsByTagName("attach")[0].innerHTML + "' alt='...' class='img-fluid'>";
        }

        html_comment += "" +
            "</div>" +

            "<div class='col-1'></div>" +

            "<div class='col-11 post_options justify-content-between'>" +
            "<a href='' class='btn rounded-pill'><i class='bi bi-heart'></i>&ensp;" + c_footer.getElementsByTagName("likes")[0].getAttribute('nLikes') + "</a>" +
            "<a href='' class='btn rounded-pill'><i class='bi bi-chat'></i>&ensp;" + footer.getElementsByTagName("comments")[0].getAttribute('nComments') + "</a>" +
            "<a href='' class='btn rounded-pill'><i class='bi bi-bookmark'></i></a>" +
            "</div>" +
            "</div>" +
            "</div>";
    }

    return [html_post, html_comment];
}

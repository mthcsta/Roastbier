<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="partials/header.jsp" %>
<div class="all-content-container">

    <!-- Top Menu -->
    <%@ include file="partials/menubar.jsp" %>

    <div class="container-fluid">
        <div class="row">

            <!-- Sidebar Menu -->
            <%@ include file="partials/sidebar.jsp" %>

            <!-- Main Content -->
            <main role="main" class="col-md-8 bg-roastbier-main">
                <div class="container">
                    <br>
                    <h1>About The Team</h1>
                    <hr>
                    <h2>A brief history of our path that led us as professionals:</h2>

                    <div class="box">
                        <img class="team-img" src="src/img/whole-team.jpg" alt="Image of the team">
                        <p class="description">
                            At the heart of "Roastbier," a craft brewery known for its exceptional beers, was a passionate and dedicated team. Led by the master brewer, this team of talented individuals shared a common goal of creating captivating flavors. With expertise in blending malts, hops, and yeast strains, they crafted a diverse range of beers, each with its own distinct character and personality.
                        </p>
                        <p class="description">
                            The brewers at Roastbier were meticulous in their approach, carefully monitoring the brewing process to ensure the perfect balance of flavors. Their commitment to quality and attention to detail resulted in every batch of beer being a testament to their craftsmanship.
                        </p>

                        <div class="right-image">
                            <img class="beers-img" src="src/img/ourbeers.jpg" alt="Image of our beers">
                        </div>

                        <p class="description thebeers">
                            Roastbier's craft beers stood out for their remarkable relevance and originality. Unlike mass-produced beers, these creations were born out of experimentation, innovation, and a deep understanding of the brewing process. The team constantly pushed boundaries, exploring new flavor combinations that made their beers unique and memorable. With a focus on using high-quality, locally sourced ingredients, Roastbier enhanced the originality of their brews, collaborating with local farmers and suppliers. Their unwavering dedication to their craft and relentless pursuit of pushing the boundaries made Roastbier a trailblazer in the world of artisanal beers, attracting beer enthusiasts who sought out their exceptional offerings.
                        </p>
                    </div>

                </div>
            </main>

            <!-- Market Menu -->
            <%@ include file="partials/buy.jsp" %>

        </div>
    </div>
</div>
<%@ include file="partials/footer.jsp" %>
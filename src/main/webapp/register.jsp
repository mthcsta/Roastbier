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
                    <h1>Register</h1>
                    <hr>
                    <div class="box">

                        <form id="myForm" onsubmit="return validar();">

                            <ul id="erros" style="color: #FF0000;"></ul>

                            <!--"required" foram removidos dos elementos html para poder haver teste da validação por javascript-->

                            <div>
                                <label for="nome">Name:</label>
                                <input type="text" id="nome" name="nome" maxlength="100">
                            </div>
                            <br>
                            <div>
                                <label for="cpf">CPF:</label>
                                <input type="text" id="cpf" name="cpf" maxlength="15">
                            </div>
                            <br>
                            <div>
                                <label for="dataNascimento">Birth Date:</label>
                                <input type="text" id="dataNascimento" name="dataNascimento" placeholder="dd/mm/yyyy">
                            </div>
                            <br>
                            <div>
                                <label for="endereco">Address:</label>
                                <br>
                                <textarea id="endereco" name="endereco" maxlength="255"></textarea>
                            </div>
                            <br>
                            <div>
                                <label for="estado">State:</label>
                                <select id="estado" name="estado" >

                                    <option value="" selected="selected" disabled="disabled">Select an option</option>

                                </select>
                            </div>
                            <br>
                            <div>
                                <label>Gender:</label>
                                <label><input type="radio" name="genero" value="masculino" > Male</label>
                                <label><input type="radio" name="genero" value="feminino" > Female</label>
                                <br>
                                <label><input type="radio" name="genero" value="outro" > Other</label>
                                <input type="text" id="outroGenero" name="outroGenero" maxlength="30" placeholder="Other">
                            </div>
                            <br>
                            <div>
                                <label for="email">E-mail:</label>
                                <input type="email" id="email" name="email" maxlength="200">
                            </div>
                            <br>
                            <div>
                                <label>Preferências:</label>
                                <label><input type="checkbox" name="preferencias" value="esportes"> Sports</label>
                                <label><input type="checkbox" name="preferencias" value="cinema"> Cinema</label>
                                <label><input type="checkbox" name="preferencias" value="teatro"> Theater</label>
                                <label><input type="checkbox" name="preferencias" value="música"> Music</label>
                                <label><input type="checkbox" name="preferencias" value="educação"> Education</label>
                                <label><input type="checkbox" name="preferencias" value="cultura"> Culture</label>
                                <label><input type="checkbox" name="preferencias" value="tecnologia"> Technology</label>
                            </div>
                            <div>
                                <button type="submit" class="btnSubmit">Save</button>
                                <button type="reset" class="btnCancel">Cancel</button>
                            </div>
                        </form>
                    </div>

                </div>
            </main>

            <!-- Market Menu -->
            <%@ include file="partials/buy.jsp" %>

        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>

<script src="src/scripts/script.js" language="javascript" type="text/javascript"></script>
<%@ include file="partials/footer.jsp" %>
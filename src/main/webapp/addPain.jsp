<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/31/2023
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="pain" method="post">
    <h3 id="demo"></h3>
    <input type="range" name="level" min="0" max="10" value="0" class="slider" id="myRange">
    <select name="location" >
        <option value="abdomen">Abdomen</option>
        <option value="back">Back</option>
        <option value="chest">Chest</option>
        <option value="head">Head</option>
        <option value="neck">Neck</option>
        <option value="hips">Hips</option>
    </select>
    <select name="symptoms" >
        <option value="cramps">Cramps</option>
        <option value="tenderBreasts">Tender Breasts</option>
        <option value="acne">Acne</option>
        <option value="fatigue">Fatigue</option>
        <option value="bloating">Bloating</option>
        <option value="craving">Craving</option>
    </select>
    <select name="painWorse" >
        <option value="lackOfSleep">Lack of sleep</option>
        <option value="sitting">Sitting</option>
        <option value="standing">Standing</option>
        <option value="stress">Stress</option>
        <option value="walking">Walking</option>
        <option value="exercise">Exercise</option>
        <option value="urination">Urination</option>
    </select>
    <select name="feeling" >
        <option value="anxious">Anxious</option>
        <option value="depressed">Depressed</option>
        <option value="dizzy">Dizzy</option>
        <option value="vomiting">Vomiting</option>
        <option value="diarrhea">Diarrhea</option>
    </select>
    <input type="submit" value="Submit">
</form>
<script>
    var slider = document.getElementById("myRange");
    var output = document.getElementById("demo");
    var value;
    if (slider.value == 0) {
        value = "None"
    } else if (slider.value > 0 && slider.value <= 3) {
        value = "Mid"
    } else if (slider.value > 3 && slider.value <= 5) {
        value = "Moderate"
    } else if (slider.value > 5 && slider.value <= 7) {
        value = "Severe"
    } else if (slider.value > 7) {
        value = "Very Severe"
    }
    output.innerHTML = value; // Display the default slider value

    // Update the current slider value (each time you drag the slider handle)
    slider.oninput = function() {
        if (slider.value == 0) {
            value = "None"
        } else if (slider.value > 0 && slider.value <= 3) {
            value = "Mid"
        } else if (slider.value > 3 && slider.value <= 5) {
            value = "Moderate"
        } else if (slider.value > 5 && slider.value <= 7) {
            value = "Severe"
        } else if (slider.value > 7) {
            value = "Very Severe"
        }
        output.innerHTML = value;
    }
</script>
</body>
</html>

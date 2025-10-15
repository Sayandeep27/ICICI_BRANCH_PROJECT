$(function() {
  let current = { section: null, item: null };
  function showModal(section, item) {
    current.section = section; current.item = item;
    $('#selectedText').text(section + " - " + item);
    $('#remarks').val('');
    $('#photo').val('');
    $('#remarkModal').show();
  }
  function hideModal() {
    $('#remarkModal').hide();
  }

  $('.checklist-item').on('click', function() {
    const section = $(this).data('section');
    const item = $(this).data('item');
    showModal(section, item);
  });

  $('#closeModal, #cancelBtn').on('click', function() {
    hideModal();
  });

  $('#submitBtn').on('click', function() {
    const remarks = $('#remarks').val();
    const branchId = $('#branchId').val();
    const token = $('#token').val();
    const mobile = ''; // token subject will be used by backend via JWT filter

    const file = document.getElementById('photo').files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = function(e) {
        const base64 = e.target.result;
        sendData(base64);
      };
      reader.readAsDataURL(file);
    } else {
      sendData(null);
    }

    hideModal();

    function sendData(imageBase64) {
      const payload = {
        section: current.section,
        item: current.item,
        remarks: remarks,
        imageBase64: imageBase64,
        branchId: branchId,
        mobile: mobile
      };

      $.ajax({
        url: '/api/checklist/submit',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(payload),
        beforeSend: function(xhr) {
          if (token) xhr.setRequestHeader('Authorization', 'Bearer ' + token);
        },
        success: function() {
          alert('Saved');
        },
        error: function(err) {
          alert('Error saving: ' + (err.responseText || err.statusText));
        }
      });
    }
  });
});

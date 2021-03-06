using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace Client.Models
{
    public class Application
    {
        [JsonPropertyName("_id")] public ObjectIDGenerator ApplicationId { get; set; }
        
        [Required, MaxLength(30)]
        [JsonPropertyName("firstName")]
        public string FirstName { get; set; }

        [Required, MaxLength(30)]
        [JsonPropertyName("lastName")]
        public string LastName { get; set; }

        [Required, MaxLength(15)]
        [ValidatePhoneNr]
        [JsonPropertyName("phoneNumber")]
        public string PhoneNumber { get; set; }

        [Required, MaxLength(30)]
        [JsonPropertyName("email")]
        public string Email { get; set; }
        
        [JsonPropertyName("jobExperience")]
        public string JobExperience { get; set; }
        
        [JsonPropertyName("drivingLicenses")]
        public string DrivingLicenses { get; set; }
        
        [JsonPropertyName("languages")]
        public string Languages { get; set; }
        
        [JsonPropertyName("preferableWorkTime")]
        public string PreferableWorkTime { get; set; }

        [JsonPropertyName("available")]
        public bool Available { get; set; } 
        
        [JsonPropertyName("user")]
        public string User { get; set; }

     

        private class ValidatePhoneNr : ValidationAttribute
        {
            protected override ValidationResult IsValid(object value, ValidationContext validationContext)
            {
                bool validator = true;

                List<string> valid = new[]
                {
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "(", ")"
                }.ToList();

                foreach (var a in value.ToString())
                {
                    if (!valid.Contains(a.ToString()))
                    {
                        validator = false;
                    }

                    if (!validator)
                    {
                        return new ValidationResult("Not valid...");
                    }
                }
                return ValidationResult.Success;
            }
        }
    }
    
}
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
        
        [JsonPropertyName("id")] public string StringId { get; set; }
        
        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("firstName")]
        public string FirstName { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("lastName")]
        public string LastName { get; set; }

        [Required, MaxLength(15)]
        [ValidatePhoneNr]
        [NotNull]
        [JsonPropertyName("phoneNumber")]
        public string PhoneNumber { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("email")]
        public string Email { get; set; }
        
        [NotNull]
        [JsonPropertyName("jobExperience")]
        public string JobExperience { get; set; }
        
        [NotNull]
        [JsonPropertyName("drivingLicenses")]
        public string DrivingLicenses { get; set; }
        
        [NotNull]
        [JsonPropertyName("languages")]
        public string Languages { get; set; }
        
        [NotNull]
        [JsonPropertyName("preferableWorkTime")]
        public string PreferableWorkTime { get; set; }

        [JsonPropertyName("availability")]
        public bool Available { get; set; } = true;
        

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
                        return new ValidationResult("huita..");
                    }
                }
                return ValidationResult.Success;
            }
        }
    }
    
}
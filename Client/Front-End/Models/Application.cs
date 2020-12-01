using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace AndriuhaAssignment.Models
{
    public class Application
    {
        [JsonPropertyName("_id")] public ObjectIDGenerator ApplicationId { get; set; }
        
        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("firstName")]
        public string FirstName { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("lastName")]
        public string LastName { get; set; }
        
        [Required]
        [NotNull]
        [JsonPropertyName("sex")]
        public string Sex { get; set; }
        
        [Required]
        [NotNull]
        [JsonPropertyName("dateOfBirth")]
        public string DateOfBirth { get; set; }
        
        [Required, MaxLength(15)]
        [ValidatePhoneNr]
        [NotNull]
        [JsonPropertyName("phoneNumber")]
        public string PhoneNumber { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("email")]
        public string Email { get; set; }
        
        [Required]
        [NotNull]
        [JsonPropertyName("jobExperience")]
        public string JobExperience { get; set; }
        

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
                    Console.Out.WriteLine(value.ToString());
                    Console.Out.WriteLine(a);
                    Console.Out.WriteLine(valid.Contains(a.ToString()));
                    if (!valid.Contains(a.ToString()))
                    {
                        validator = false;
                    }

                    if (!validator)
                    {
                        Console.Out.WriteLine("opa");
                        return new ValidationResult("huita..");
                    }
                }
                return ValidationResult.Success;
            }
        }
    }
    
}